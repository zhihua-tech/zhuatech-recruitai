/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.workbench;

import static cn.zhuatech.recruitai.workbench.WorkbenchInput.*;

import java.math.*;
import java.util.*;
import org.springframework.stereotype.Service;

/** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
@Service
public class AiWorkbenchService {
  /** 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。 */
  public Map<String, Object> execute(Map<String, Object> r) {
    validate(r);
    keys(r, "durationMinutes", "participants");
    int duration = integer(r, "durationMinutes", 1, 480);
    var people = rows(r, "participants", 1, 20);
    Set<String> ids = new HashSet<>();
    Set<java.time.LocalDateTime> boundary = new TreeSet<>();
    List<List<java.time.LocalDateTime[]>> availability = new ArrayList<>(),
        busyTimes = new ArrayList<>();
    for (var p : people) {
      keys(p, "id", "available", "busy");
      unique(ids, id(p, "id"));
      for (String key : List.of("available", "busy")) {
        List<java.time.LocalDateTime[]> parsed = new ArrayList<>();
        for (var interval : rows(p, key, key.equals("available") ? 1 : 0, 50)) {
          keys(interval, "start", "end");
          var a = local(text(interval, "start", 30));
          var b = local(text(interval, "end", 30));
          if (!a.isBefore(b) || java.time.Duration.between(a, b).toMinutes() > 44640)
            throw new IllegalArgumentException("空闲区间须正向且不超过31天");
          boundary.add(a);
          boundary.add(b);
          parsed.add(new java.time.LocalDateTime[] {a, b});
        }
        if (key.equals("available")) availability.add(parsed);
        else busyTimes.add(parsed);
      }
    }
    var points = new ArrayList<>(boundary);
    List<java.time.LocalDateTime[]> free = new ArrayList<>();
    for (int i = 0; i + 1 < points.size(); i++) {
      var a = points.get(i);
      var b = points.get(i + 1);
      boolean all = true;
      for (int person = 0; person < people.size(); person++) {
        boolean available = false, busy = false;
        for (var x : availability.get(person))
          if (!x[0].isAfter(a) && !x[1].isBefore(b)) {
            available = true;
            break;
          }
        for (var x : busyTimes.get(person))
          if (x[0].isBefore(b) && x[1].isAfter(a)) {
            busy = true;
            break;
          }
        if (!available || busy) {
          all = false;
          break;
        }
      }
      if (all) {
        if (!free.isEmpty() && free.getLast()[1].equals(a)) free.getLast()[1] = b;
        else free.add(new java.time.LocalDateTime[] {a, b});
      }
    }
    List<Map<String, Object>> out = new ArrayList<>();
    for (var interval : free) {
      long minutes = java.time.Duration.between(interval[0], interval[1]).toMinutes();
      if (minutes >= duration)
        out.add(
            Map.of(
                "start",
                interval[0].toString(),
                "end",
                interval[1].toString(),
                "availableMinutes",
                minutes,
                "latestStart",
                interval[1].minusMinutes(duration).toString()));
    }
    return Map.of("durationMinutes", duration, "slots", out, "automaticInvitation", false);
  }
}

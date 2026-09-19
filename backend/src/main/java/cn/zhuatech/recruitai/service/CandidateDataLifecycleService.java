/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 管理候选人数据的告知、用途、保留、删除请求与法律保全。
 *
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class CandidateDataLifecycleService{
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Result decide(Request r){List<String>reasons=new ArrayList<>(),actions=new ArrayList<>(),allowed=new ArrayList<>();boolean expired=r.applicationClosed()&&r.daysSinceClosure()>=r.retentionDays();Decision d;
  if((r.erasureRequested()||expired)&&!r.legalHold()&&!r.activeDispute()){d=Decision.DELETE;reasons.add(r.erasureRequested()?"候选人提出有效删除请求":"招聘记录超过批准保留期");actions.add("删除简历、解析结果、模型特征和非必要审计副本");actions.add("保留不可反推个人的删除证明");}
  else if((r.erasureRequested()||expired)&&(r.legalHold()||r.activeDispute())){d=Decision.RESTRICT;reasons.add("删除条件满足但存在法律保全或在途争议");actions.add("冻结非必要访问，仅允许法务保全用途");}
  else if(!r.aiProcessingNoticeProvided()||!r.processingBasisRecorded()){d=Decision.RESTRICT;reasons.add("AI 处理告知或处理依据不完整");actions.add("暂停画像、匹配和人才库复用，补充告知与处理依据");}
  else{d=Decision.RETAIN;allowed.add("当前岗位评估");if(r.talentPoolConsent())allowed.add("人才库匹配");actions.add("按最小权限保留并在到期时自动触发复核");}
  if(r.sensitiveAttributesPresent())actions.add("隔离受保护属性，不允许进入推荐排序特征");
  return new Result(d,Math.max(0,r.retentionDays()-r.daysSinceClosure()),List.copyOf(allowed),List.copyOf(reasons),List.copyOf(actions));}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@NotBlank String candidateId,boolean applicationClosed,@Min(0)int daysSinceClosure,@Min(1)@Max(3650)int retentionDays,boolean erasureRequested,boolean legalHold,boolean activeDispute,boolean aiProcessingNoticeProvided,boolean processingBasisRecorded,boolean talentPoolConsent,boolean sensitiveAttributesPresent){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Result(Decision decision,int remainingRetentionDays,List<String>allowedPurposes,List<String>reasons,List<String>actions){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public enum Decision{RETAIN,RESTRICT,DELETE}
}

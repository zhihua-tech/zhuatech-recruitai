/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.config;
import cn.zhuatech.recruitai.model.*; import cn.zhuatech.recruitai.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder; import java.time.LocalDate; import java.util.List;
@Configuration public class DataInitializer {
 @Bean CommandLineRunner seed(OperatingUnitRepository units,WorkRecordRepository orders,ResourceRegisterRepository resources,ReviewRecordRepository reviews,UserRepository users,PasswordEncoder encoder){return args->{if(units.count()>0)return;
 var u1=units.save(new OperatingUnit("REC-TECH","技术招聘组","研发中心",180));var u2=units.save(new OperatingUnit("REC-PROD","产品招聘组","产品中心",120));var u3=units.save(new OperatingUnit("REC-BIZ","业务招聘组","商业中心",96));
 var t1=orders.save(new WorkRecord("REC-260804-018","JAVA-SENIOR","高级 Java 工程师招聘",u1,24,16,1,LocalDate.now().plusDays(1),WorkRecord.Status.RUNNING,"社会招聘"));
 var t2=orders.save(new WorkRecord("REC-260804-021","AI-PM","AI 产品经理人才寻访",u2,18,8,0,LocalDate.now().plusDays(2),WorkRecord.Status.RUNNING,"关键岗位"));
 var t3=orders.save(new WorkRecord("REC-260804-026","CSM-SH","客户成功经理招聘",u1,12,0,0,LocalDate.now().plusDays(3),WorkRecord.Status.RELEASED,"社会招聘"));
 var t4=orders.save(new WorkRecord("REC-260803-015","DATA-INTERN","数据分析实习生项目",u3,20,20,1,LocalDate.now(),WorkRecord.Status.COMPLETED,"校园招聘"));
 resources.saveAll(List.of(new ResourceRegister("CV-PARSER-01","简历解析服务",u1,ResourceRegister.Status.RUNNING,97),new ResourceRegister("JD-MATCH-02","人才匹配引擎",u2,ResourceRegister.Status.IDLE,86),new ResourceRegister("INTERVIEW-03","面试协同助手",u3,ResourceRegister.Status.RUNNING,91),new ResourceRegister("CONSENT-04","候选人授权检查",u1,ResourceRegister.Status.ALARM,68)));
 reviews.saveAll(List.of(new ReviewRecord("RV-260804-032",t1,"人工复核",6,0,ReviewRecord.Result.PASSED,"林岚"),new ReviewRecord("RV-260804-011",t2,"质量检查",3,0,ReviewRecord.Result.PASSED,"顾晨"),new ReviewRecord("RV-260803-018",t4,"结果抽查",5,1,ReviewRecord.Result.FAILED,"林岚"),new ReviewRecord("RV-260804-003",t3,"上线确认",4,0,ReviewRecord.Result.PENDING,"顾晨")));
 String demo=encoder.encode("Demo@2026");users.saveAll(List.of(new UserAccount("operator",demo,"顾晨",UserAccount.Role.DOMAIN_USER,"REC-TECH"),new UserAccount("planner",demo,"林岚",UserAccount.Role.DOMAIN_OPERATOR,null),new UserAccount("quality",demo,"顾清",UserAccount.Role.QUALITY,null),new UserAccount("admin",encoder.encode("ZhuaTech@2026"),"系统管理员",UserAccount.Role.ADMIN,null)));};}
}
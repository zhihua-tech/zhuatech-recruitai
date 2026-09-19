/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.service;import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.assertThat;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class CandidateDataLifecycleServiceTest{private final CandidateDataLifecycleService s=new CandidateDataLifecycleService();
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void retainsForApprovedPurposes(){var r=s.decide(req(false,false,false,true,true,true,30));assertThat(r.decision()).isEqualTo(CandidateDataLifecycleService.Decision.RETAIN);assertThat(r.allowedPurposes()).containsExactly("当前岗位评估","人才库匹配");}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void deletesExpiredCandidateData(){var r=s.decide(req(false,false,false,true,true,false,400));assertThat(r.decision()).isEqualTo(CandidateDataLifecycleService.Decision.DELETE);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 @Test void restrictsDeletionDuringLegalHold(){var r=s.decide(req(true,true,false,true,true,false,10));assertThat(r.decision()).isEqualTo(CandidateDataLifecycleService.Decision.RESTRICT);assertThat(r.allowedPurposes()).isEmpty();}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 private CandidateDataLifecycleService.Request req(boolean erase,boolean hold,boolean dispute,boolean notice,boolean basis,boolean pool,int days){return new CandidateDataLifecycleService.Request("C-1",true,days,365,erase,hold,dispute,notice,basis,pool,true);}}

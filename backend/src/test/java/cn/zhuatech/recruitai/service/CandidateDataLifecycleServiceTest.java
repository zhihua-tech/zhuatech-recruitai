/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.service;import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.assertThat;
class CandidateDataLifecycleServiceTest{private final CandidateDataLifecycleService s=new CandidateDataLifecycleService();
 @Test void retainsForApprovedPurposes(){var r=s.decide(req(false,false,false,true,true,true,30));assertThat(r.decision()).isEqualTo(CandidateDataLifecycleService.Decision.RETAIN);assertThat(r.allowedPurposes()).containsExactly("当前岗位评估","人才库匹配");}
 @Test void deletesExpiredCandidateData(){var r=s.decide(req(false,false,false,true,true,false,400));assertThat(r.decision()).isEqualTo(CandidateDataLifecycleService.Decision.DELETE);}
 @Test void restrictsDeletionDuringLegalHold(){var r=s.decide(req(true,true,false,true,true,false,10));assertThat(r.decision()).isEqualTo(CandidateDataLifecycleService.Decision.RESTRICT);assertThat(r.allowedPurposes()).isEmpty();}
 private CandidateDataLifecycleService.Request req(boolean erase,boolean hold,boolean dispute,boolean notice,boolean basis,boolean pool,int days){return new CandidateDataLifecycleService.Request("C-1",true,days,365,erase,hold,dispute,notice,basis,pool,true);}}

/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai;import cn.zhuatech.recruitai.service.InterviewFairnessService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class InterviewFairnessServiceTests{private final InterviewFairnessService s=new InterviewFairnessService();/**
                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                             */
@Test void blocksProtectedAttributeUse(){var r=s.evaluate(new InterviewFairnessService.Request(true,true,3,3,true,true,true));assertEquals("BLOCK",r.status());}/**
                                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                             */
@Test void approvesStructuredProcess(){var r=s.evaluate(new InterviewFairnessService.Request(true,true,3,3,false,true,true));assertEquals("READY",r.status());}}

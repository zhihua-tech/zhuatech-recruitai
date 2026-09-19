/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.controller;import cn.zhuatech.recruitai.common.ApiResponse;import cn.zhuatech.recruitai.service.CandidateDataLifecycleService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController@RequestMapping("/api/enterprise/recruitai")public class CandidateDataLifecycleController{private final CandidateDataLifecycleService service;/**
                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                              */
public CandidateDataLifecycleController(CandidateDataLifecycleService s){service=s;}/**
                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                  */
@PostMapping("/candidate-data-lifecycle")public ApiResponse<CandidateDataLifecycleService.Result>decide(@Valid@RequestBody CandidateDataLifecycleService.Request r){return ApiResponse.ok("候选人数据生命周期决策完成",service.decide(r));}}

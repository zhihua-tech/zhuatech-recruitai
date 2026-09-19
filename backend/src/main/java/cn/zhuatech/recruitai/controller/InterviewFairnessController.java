/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.controller;import cn.zhuatech.recruitai.common.ApiResponse;import cn.zhuatech.recruitai.service.InterviewFairnessService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/recruitai/insights/interview-fairness") public class InterviewFairnessController{private final InterviewFairnessService service;/**
                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                       */
public InterviewFairnessController(InterviewFairnessService service){this.service=service;}/**
                                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                  */
@PostMapping ApiResponse<InterviewFairnessService.Result> evaluate(@Valid @RequestBody InterviewFairnessService.Request r){return ApiResponse.ok(service.evaluate(r));}}

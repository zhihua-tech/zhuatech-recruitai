/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.controller;

import cn.zhuatech.recruitai.common.ApiResponse;
import cn.zhuatech.recruitai.service.HiringRecommendationReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/recruitai")
public class HiringRecommendationReleaseController {
    private final HiringRecommendationReleaseService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public HiringRecommendationReleaseController(HiringRecommendationReleaseService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/hiring-recommendation-release")
    public ApiResponse<HiringRecommendationReleaseService.Assessment> assess(
            @Valid @RequestBody HiringRecommendationReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}

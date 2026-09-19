/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.recruitai.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class HiringRecommendationReleaseServiceTest {
    private final HiringRecommendationReleaseService service = new HiringRecommendationReleaseService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void releasesGovernedRecommendation() {
        var result = service.assess(new HiringRecommendationReleaseService.Request("H1", true, true, true,
                true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(HiringRecommendationReleaseService.Decision.RELEASE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void routesOperationalGapsToPanel() {
        var result = service.assess(new HiringRecommendationReleaseService.Request("H2", true, true, true,
                true, true, true, false, false, false, true));
        assertThat(result.actions()).hasSize(3);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnfairRecommendation() {
        var result = service.assess(new HiringRecommendationReleaseService.Request("H3", false, false, false,
                false, false, false, true, true, true, false));
        assertThat(result.blockers()).hasSize(7);
    }
}

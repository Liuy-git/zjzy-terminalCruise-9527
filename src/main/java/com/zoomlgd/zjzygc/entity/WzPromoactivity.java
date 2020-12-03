package com.zoomlgd.zjzygc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author demo
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("WZ_PROMOACTIVITY")
public class WzPromoactivity extends Model<WzPromoactivity> {

    private static final long serialVersionUID = 1L;

    /**
     * 详细用法
     */
    @TableField("DETAILED_USAGE")
    private String detailedUsage;

    /**
     * 方案ID
     */
    @TableField("ACTIVITY_ID")
    private Integer activityId;

    /**
     * 方案编号
     */
    @TableField("ACTIVITY_CODE")
    private String activityCode;

    /**
     * 类型，1销区申报方案，2业务部申报统筹方案，3 品牌部申报统筹方案4. 业务部申报统筹方案的子方案5. 品牌部申报统筹方案的子方案
     */
    @TableField("ACTIVITY_TYPE")
    private Integer activityType;

    /**
     * 方案父id，仅限统筹子使用
     */
    @TableField("PARENT_ACTIVITY_ID")
    private Integer parentActivityId;

    /**
     * 省内市级公司id，省外省级公司ID
     */
    @TableField("COMPANY_ID1")
    private Integer companyId1;

    /**
     * 省内县级ID 省外市级ID
     */
    @TableField("COMPANY_ID2")
    private Integer companyId2;

    /**
     * 到货地点ID
     */
    @TableField("DEST_ID")
    private Integer destId;

    /**
     * 是否省内方案 0 否 1是
     */
    @TableField("IF_PROVINCE")
    private Integer ifProvince;

    /**
     * 促销类型
     */
    @TableField("PROMO_TYPE")
    private Integer promoType;

    /**
     * 方案主题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 方案目的
     */
    @TableField("TARGET")
    private String target;

    /**
     * 活动形式
     */
    @TableField("FORM")
    private String form;

    /**
     * 可行性分析
     */
    @TableField("ANALYSIS")
    private String analysis;

    /**
     * 启动日期
     */
    @TableField("BEGIN_DATE")
    private Date beginDate;

    /**
     * 结束日期
     */
    @TableField("END_DATE")
    private Date endDate;

    /**
     * 申报级别
     */
    @TableField("APPLY_LEVEL")
    private Integer applyLevel;

    /**
     * 目前审批级别
     */
    @TableField("CHECK_LEVEL")
    private Integer checkLevel;

    /**
     * 终审级别
     */
    @TableField("FINAL_LEVEL")
    private Integer finalLevel;

    /**
     * 状态，0草稿，1已提交，2驳回，3审批通过，4已评估，9已结束（说明：9以后的数字均视为结束状态，备用）
     */
    @TableField("STATE")
    private Integer state;

    /**
     * 创建人员ID
     */
    @TableField("CREATE_PERSON_ID")
    private Integer createPersonId;

    /**
     * 创建人员部门ID
     */
    @TableField("CREATE_DEPART_ID")
    private Integer createDepartId;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 当前创建层次 (1客户经理申请，2市场经理申请，3区域经理申请，4综合管理员申请，5部门经理申请)
     */
    @TableField("CREATE_LEVEL")
    private Integer createLevel;

    /**
     * 提交人ID
     */
    @TableField("APPLY_PERSON_ID")
    private Integer applyPersonId;

    /**
     * 提交部门ID
     */
    @TableField("APPLY_DEPART_ID")
    private Integer applyDepartId;

    /**
     * 提交时间
     */
    @TableField("APPLY_TIME")
    private Date applyTime;

    /**
     * 更新人ID
     */
    @TableField("UPDATE_PERSON_ID")
    private Integer updatePersonId;

    /**
     * 更新部门ID
     */
    @TableField("UPDATE_DEPART_ID")
    private Integer updateDepartId;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 结束时间
     */
    @TableField("FINISH_TIME")
    private Date finishTime;

    /**
     * 结束人ID
     */
    @TableField("FINISH_PERSON_ID")
    private Integer finishPersonId;

    /**
     * 结束人员部门ID
     */
    @TableField("FINISH_DEPART_ID")
    private Integer finishDepartId;

    /**
     * 结束状态，0 未结束  1正常结束
     */
    @TableField("FINISH_STATE")
    private Integer finishState;

    /**
     * 促销烟费用
     */
    @TableField("TOBAFEE")
    private BigDecimal tobafee;

    /**
     * 促销品费
     */
    @TableField("GOODSFEE")
    private BigDecimal goodsfee;

    /**
     * 其他费用
     */
    @TableField("OTHERFEE")
    private BigDecimal otherfee;

    /**
     * 判断     不包含其他费用 0   和  包含其他费用需品牌部审批 1
     */
    @TableField("CHECK_COST")
    private Integer checkCost;

    /**
     * 促销烟随货到货公司id
     */
    @TableField("WL_DEST_ID")
    private Integer wlDestId;

    /**
     * 判断   是否  显示方案 0   和  隐藏方案 1
     */
    @TableField("IF_HIDDEN")
    private Integer ifHidden;

    /**
     * 只限统筹方案使用  统筹类型 1 需销区分解 2 无销区需分解
     */
    @TableField("OVERALL_TYPE")
    private Integer overallType;

    /**
     * 24小时区域经理未审批短信是否已发送 0 未发送 1 已发送
     */
    @TableField("SMSSEND_24HOURUNCHECK_FLAG2")
    private Integer smssend24houruncheckFlag2;

    /**
     * 48小时区域经理未审批短信是否已发送 0 未发送 1 已发送
     */
    @TableField("SMSSEND_48HOURUNCHECK_FLAG2")
    private Integer smssend48houruncheckFlag2;

    /**
     * 24小时市场经理未审批短信是否已发送 0 未发送 1 已发送
     */
    @TableField("SMSSEND_24HOURUNCHECK_FLAG")
    private Integer smssend24houruncheckFlag;

    /**
     * 48小时市场经理未审批短信是否已发送 0 未发送 1 已发送
     */
    @TableField("SMSSEND_48HOURUNCHECK_FLAG")
    private Integer smssend48houruncheckFlag;

    /**
     * 统筹方案分解方式  1按市场  2按销区业务员 3按终端业务员 4按库存采集点 5按价格采集点
     */
    @TableField("RESOLVE_TYPE")
    private Integer resolveType;

    /**
     * 省内烟模方案烟模类型 0 单品系烟模 1 访销线烟模
     */
    @TableField("TOBA_MODEL_TYPE")
    private Integer tobaModelType;

    /**
     * 发运说明
     */
    @TableField("SHIPPING_NOTE")
    private String shippingNote;

    /**
     * 样烟类型，1 营销用烟 2 品吸烟  3 试制烟
     */
    @TableField("TOBA_TYPE")
    private Integer tobaType;

    /**
     * 运输类型
     */
    @TableField("WL_TYPE")
    private Integer wlType;

    /**
     * 主题id
     */
    @TableField("THEME_ID")
    private Integer themeId;

    /**
     * 是否模板申报 0否1是
     */
    @TableField("IF_TEMPLATE")
    private Integer ifTemplate;

    @TableField("PREPARE_TIME")
    private Date prepareTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

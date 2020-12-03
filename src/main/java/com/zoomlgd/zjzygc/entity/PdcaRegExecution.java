package com.zoomlgd.zjzygc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 写实类活动业务员执行登记主表
 * </p>
 *
 * @author demo
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PDCA_REG_EXECUTION")
public class PdcaRegExecution extends Model<PdcaRegExecution> {

    private static final long serialVersionUID = 1L;

    /**
     * 自编号
     */
    @TableField("REG_ID")
    private Integer regId;

    /**
     * 执行登记编号
     */
    @TableField("REG_CODE")
    private String regCode;

    /**
     * 方案编号
     */
    @TableField("ACTIVITY_ID")
    private Integer activityId;

    /**
     * 地市
     */
    @TableField("COMPANY_ID")
    private Integer companyId;

    /**
     * 活动主题ID
     */
    @TableField("THEME_ID")
    private Integer themeId;

    /**
     * 活动类型
     */
    @TableField("PROMO_TYPE_ID")
    private Integer promoTypeId;

    /**
     * 活动时间
     */
    @TableField("ACTIVITYTIME")
    private Date activitytime;

    /**
     * 活动对象
     */
    @TableField("TARGET_ID")
    private Integer targetId;

    /**
     * 执行类型  1 业务员 2 终端业务员
     */
    @TableField("EXECUTETYPE")
    private Integer executetype;

    /**
     * 创建时间
     */
    @TableField("CREATETIME")
    private Date createtime;

    /**
     * 创建人
     */
    @TableField("CREATEPERSON_ID")
    private Integer createpersonId;

    /**
     * 活动形式
     */
    @TableField("FORM")
    private String form;

    /**
     *  单据类型 1 为正式执行单 2 为修改申请单 3删除申请
     */
    @TableField("BILL_TYPE")
    private Integer billType;

    /**
     *  修改申请单对应的原执行单id
     */
    @TableField("EDITAPPLY_PARENT_ID")
    private Integer editapplyParentId;

    /**
     *  删除标志  删除标志 0正常,1删除
     */
    @TableField("DEL_FLAG")
    private Integer delFlag;

    /**
     *  对应同步到营销物资系统执行登记单的id
     */
    @TableField("WZSALE_REG_ID")
    private Integer wzsaleRegId;

    /**
     * 上级审批ID
     */
    @TableField("CHECK_ROLE_ID")
    private Integer checkRoleId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

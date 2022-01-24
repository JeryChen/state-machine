package org.xy.machine.builder;

/**
 * <功能介绍><br>
 * <p>
 * <外部转换生成器>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ExternalTransitionBuilder<S, E, C> {

    /**
     * 构建转换源状态
     *
     * @param stateId 状态标识id
     *
     * @return 从子句生成器
     */
    From<S, E, C> from(S stateId);
}

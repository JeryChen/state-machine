package org.xy.machine.builder;

/**
 * <功能介绍><br>
 * <p>
 * <"从"子句生成器>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface From<S, E, C> {

    /**
     * 构建转换目标状态并返回子句构建器
     *
     * @param stateId 状态标识id
     *
     * @return 到子句生成器
     */
    To<S, E, C> to(S stateId);
}

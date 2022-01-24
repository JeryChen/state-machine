package org.xy.machine.builder;

/**
 * <功能介绍><br>
 * <p>
 * <此构建器用于多转场，目前仅支持多源>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ExternalTransitionsBuilder<S, E, C> {

    /**
     * 多源构建转换源状态
     *
     * @param stateIds 状态标识ids
     *
     * @return 从子句生成器
     */
    From<S, E, C> fromAmong(S... stateIds);
}

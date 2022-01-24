package org.xy.machine.builder;

/**
 * <功能介绍><br>
 * <p>
 * <内部转换生成器>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface InternalTransitionBuilder<S, E, C> {

    /**
     * 建立内部过度
     *
     * @param stateId 过度状态标识id
     *
     * @return "到"子句生成器
     */
    To<S, E, C> within(S stateId);
}

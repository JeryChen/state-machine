package org.xy.machine.builder;

/**
 * <功能介绍><br>
 * <p>
 * <状态机构建器工厂>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateMachineBuilderFactory {

    /**
     * 创建状态机构建器
     *
     * @param <S> 源状态标识符
     * @param <E> 事件
     * @param <C> 上下文信息
     *
     * @return 状态机构建器
     */
    public static <S, E, C> StateMachineBuilder<S, E, C> create() {
        return new StateMachineBuilderImpl<>();
    }
}

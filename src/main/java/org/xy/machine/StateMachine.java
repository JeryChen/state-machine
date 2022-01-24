package org.xy.machine;

/**
 * <功能介绍><br>
 * <p>
 * <状态机>
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface StateMachine<S, E, C> extends Visitable {

    /**
     * 向状态机发送事件
     *
     * @param sourceStateId 源状态
     * @param event       发送的时间
     * @param ctx         用户定义的上下文
     *
     * @return 目标状态标识id
     */
    S fireEvent(S sourceStateId, E event, C ctx);

    /**
     * 获取状态机的标识符
     *
     * @return 状态机的标识符
     */
    String getMachineId();

    /**
     * 使用访问者模式展示状态机的结构
     */
    void showStateMachine();

    /**
     * 生成plantUML流程
     *
     * @return plantUML流程
     */
    String generatePlantUml();
}

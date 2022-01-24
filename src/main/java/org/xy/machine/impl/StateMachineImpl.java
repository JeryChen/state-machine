package org.xy.machine.impl;

import org.xy.machine.State;
import org.xy.machine.StateMachine;
import org.xy.machine.Transition;
import org.xy.machine.Visitor;
import org.xy.machine.exception.StateMachineException;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * <功能介绍><br>
 * <p>
 * <状态机实现>
 * 这里的状态机故意设置为无状态的，构建完成后，可以多线程共享
 * <p>
 * 同时带来的一个问题：由于状态机是无状态的，我们无法从状态机中获取当前状态。
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateMachineImpl<S, E, C> implements StateMachine<S, E, C> {

    /**
     * 状态机标识id
     */
    private String machineId;

    /**
     * 状态容器
     */
    private final Map<S, State<S, E, C>> stateMap;

    /**
     * 是否准备完成
     */
    private boolean ready;

    public StateMachineImpl(Map<S, State<S, E, C>> stateMap) {
        this.stateMap = stateMap;
    }

    /**
     * 向状态机发送事件
     *
     * @param sourceStateId 源状态
     * @param event         发送的时间
     * @param ctx           用户定义的上下文
     *
     * @return 目标状态标识id
     */
    @Override
    public S fireEvent(S sourceStateId, E event, C ctx) {
        isReady();
        State sourceState = getState(sourceStateId);
        return doTransition(sourceState, event, ctx).getId();
    }

    /**
     * 获取状态机的标识符
     *
     * @return 状态机的标识符
     */
    @Override
    public String getMachineId() {
        return machineId;
    }

    /**
     * 使用访问者模式展示状态机的结构
     */
    @Override
    public void showStateMachine() {
        SysOutVisitor sysOutVisitor = new SysOutVisitor();
        accept(sysOutVisitor);
    }

    /**
     * 生成plantUML流程
     *
     * @return plantUML流程
     */
    @Override
    public String generatePlantUml() {
        PlantUmlVisitor plantUmlVisitor = new PlantUmlVisitor();
        return accept(plantUmlVisitor);
    }

    /**
     * 接受处理
     *
     * @param visitor 访问者
     *
     * @return 访问者进入和退出结果
     */
    @Override
    public String accept(Visitor visitor) {
        StringBuilder sb = new StringBuilder();
        sb.append(visitor.visitOnEntry(this));
        for (State state : stateMap.values()) {
            sb.append(state.accept(visitor));
        }
        sb.append(visitor.visitOnExit(this));
        return sb.toString();
    }

    private void isReady() {
        if (!ready) {
            throw new StateMachineException("State machine is not built yet, can not work");
        }
    }

    private State getState(S currentStateId) {
        State state = StateHelper.getState(stateMap, currentStateId);
        if (Objects.isNull(state)) {
            showStateMachine();
            throw new StateMachineException(currentStateId + " is not found, please check state machine");
        }
        return state;
    }

    private State<S, E, C> doTransition(State sourceState, E event, C ctx) {
        Optional<Transition<S, E, C>> transition = sourceState.getTransition(event);
        if (transition.isPresent()) {
            return transition.get()
                             .transit(ctx);
        }
        Debugger.debug("There is no Transition for " + event);
        return sourceState;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}

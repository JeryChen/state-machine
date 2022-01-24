package org.xy.machine;

import org.xy.machine.exception.StateMachineException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <功能介绍><br>
 * <p>
 * <状态机构建工厂>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateMachineFactory {

    /**
     * key为machineId
     */
    @SuppressWarnings("rawtypes")
    private final static Map<String, StateMachine> STATE_MACHINE_MAP = new ConcurrentHashMap<>();

    /**
     * 注册状态机
     *
     * @param stateMachine 状态机
     * @param <S>          源状态标识符
     * @param <E>          事件
     * @param <C>          上下文信息
     */
    public static <S, E, C> void register(StateMachine<S, E, C> stateMachine) {
        String machineId = stateMachine.getMachineId();
        if (STATE_MACHINE_MAP.get(machineId) != null) {
            throw new StateMachineException("The state machine with id [" + machineId + "] is already built, no need to build again");
        }
        STATE_MACHINE_MAP.put(stateMachine.getMachineId(), stateMachine);
    }

    /**
     * 获取状态机
     *
     * @param machineId 状态机标识符id
     * @param <S>       源状态标识符
     * @param <E>       事件
     * @param <C>       上下文信息
     *
     * @return 状态机
     */
    public static <S, E, C> StateMachine<S, E, C> get(String machineId) {
        StateMachine stateMachine = STATE_MACHINE_MAP.get(machineId);
        if (stateMachine == null) {
            throw new StateMachineException("There is no stateMachine instance for " + machineId + ", please build it first");
        }
        return stateMachine;
    }

}

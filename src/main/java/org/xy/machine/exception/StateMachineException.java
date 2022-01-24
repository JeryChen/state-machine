package org.xy.machine.exception;

/**
 * <功能介绍><br>
 * <p>
 * <状态机异常类>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateMachineException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public StateMachineException(String message) {
        super(message);
    }
}

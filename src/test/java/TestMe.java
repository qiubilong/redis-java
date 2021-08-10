import com.study.redis.redis.command.RedisCommandProc;
import com.study.redis.redis.h.RedisCommand;

/**
 * @author chenxuegui
 * @since 2021.08.10
 */
public class TestMe {


    public static void main(String[] args) {
        for (RedisCommandProc proc : RedisCommandProc.values()) {
            RedisCommand command = proc.getRedisCommandVo();
            char[] chars = command.getSflags().toCharArray();
            byte[] bytes = command.getSflags().getBytes();
            System.out.println(bytes);
        }
    }
}

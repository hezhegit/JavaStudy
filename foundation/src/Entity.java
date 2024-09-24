import java.util.Objects;

/**
 * @ClassName Entity
 * @Description TODO
 * @Author 小何
 * @Date 2024/9/24 13:27
 **/
public class Entity implements Comparable<Entity> {
    Integer a;
    Integer b;

    public Entity(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Entity o) {
        // 优先以a升序排列，其次以b降序排序
        if (!Objects.equals(this.a, o.a)){
            return this.a - o.a;
        }
        return o.b - this.b;
    }
}

package specification;

import com.itclopedia.courses.models.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> hasField(String fieldName, String value) {
        return (root, query, criteriaBuilder) -> {
            if (fieldName.equals("priority")) {
                return criteriaBuilder.equal(root.get("priority"), value);
            } else if (fieldName.equals("status")) {
                return criteriaBuilder.equal(root.get("status"), value);
            }
            return criteriaBuilder.conjunction();
        };
    }
}

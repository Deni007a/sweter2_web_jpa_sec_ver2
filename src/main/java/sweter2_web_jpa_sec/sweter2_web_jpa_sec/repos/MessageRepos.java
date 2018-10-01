package sweter2_web_jpa_sec.sweter2_web_jpa_sec.repos;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sweter2_web_jpa_sec.sweter2_web_jpa_sec.domain.Message;

import java.util.List;

@Repository
public interface MessageRepos extends CrudRepository<Message, Integer> {
    // создаем метот который ищет тег и  возвращает колекцию наденого
    List<Message> findByTag (String teg);

}
/*
// это  круд для сортировки
public interface MessageRepos extends PagingAndSortingRepository<Message, Integer> {

}
*/

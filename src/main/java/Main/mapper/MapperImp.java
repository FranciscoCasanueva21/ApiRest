package Main.mapper;
import Main.dto.UserDto;
import Main.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MapperImp implements Mapper<UserDto, User>{
    @Override
    public User map(UserDto userDto) {

        User user = new User();

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setAge(userDto.getAge());
        user.setCelphone(userDto.getCelphone());
        user.setEmail(userDto.getEmail());

        return user;
    }
}

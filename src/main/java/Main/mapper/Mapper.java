package Main.mapper;

public interface Mapper<INPUT,OUTPUT> {
    public OUTPUT map(INPUT input);

}

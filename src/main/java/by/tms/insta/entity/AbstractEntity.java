package by.tms.insta.entity;

import java.time.LocalDateTime;

public abstract class AbstractEntity {
    protected long id;
    protected LocalDateTime createAt;

    public AbstractEntity(){
    }

    public AbstractEntity(long id, LocalDateTime createAt) {
        this.id = id;
        this.createAt = createAt;
    }

    public AbstractEntity(long id){
        this.id = id;
    }
}




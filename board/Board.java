package board;

import lombok.*;

@NoArgsConstructor
@Getter
@ToString

public class Board {

    private int id;

    private String boardName;
    private String boardType;
    private String writer;

@Builder(builderMethodName = "builder")
    public Board(int id, String boardName, String boardType, String writer) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
        this.writer = writer;
    }
}

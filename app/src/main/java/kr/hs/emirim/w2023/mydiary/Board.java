package kr.hs.emirim.w2023.mydiary;

public class Board {
    private String id;
    private String title;
    private String contents;
    private String name;

    public Board(String id, String title, String contents){
        this.id =id;
        this.title = title;
        this.contents = contents;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getContents(){
        return contents;
    }
    public void setContents(String contents){
        this.contents=contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}



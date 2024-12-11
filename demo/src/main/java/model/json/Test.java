package model.json;

import java.util.List;

public class Test {
    public static void main(String[] args) {
    List<NewsDO> newsDOList = new JsonDAO<NewsDo>.getAll();

    }
}

package edu.yuwen.dp.structure.flyweight.word;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * 7.享元模式（结构型）
 * 
 * 
 *
 * Demo:Word文本编辑器，每个字符都有一个样式，但是样式个数不会太多
 */
public class Editor {
    private List<Character> chars = new ArrayList<>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
}
package by.epam.task03.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Section> sections;

    public Menu() {
    	sections = new ArrayList<>();
    }

    public Menu(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return !(sections != null ? !sections.equals(menu.sections) : menu.sections != null);

    }

    @Override
    public int hashCode() {
        return sections != null ? sections.hashCode() : 0;
    }

    @Override
    public String toString() {
        String resultString = "����:\n";
        for (Section section : sections) {
            resultString = resultString + section;
        }
        return resultString;
    }
}
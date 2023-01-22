package it.unical.demacs.view;

public class TopButton extends MyButton{
    public static final int HOME = 0;
    private int type;

    public TopButton(String str, int type) {
        super(str);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}

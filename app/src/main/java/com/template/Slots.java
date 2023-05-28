package com.template;

public class Slots extends  Thread{


    interface WheelListener {
        void newImage(int img);
    }

    private static int[] drawables = {R.drawable.ico_1, R.drawable.ico_2, R.drawable.ico_3,
            R.drawable.ico_4, R.drawable.ico_5, R.drawable.ico_6};
    public int currentIndex;
    private WheelListener slotsListener;
    private long frameDuration;
    private long startIn;
    private boolean isStarted;

    public Slots(WheelListener slotsListener, long frameDuration, long startIn) {
        this.slotsListener = slotsListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        currentIndex = 0;
        isStarted = true;
    }

    public void nextImg() {
        currentIndex++;

        if (currentIndex == drawables.length) {
            currentIndex = 0;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
        }

        while (isStarted) {
            try {
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
            }

            nextImg();

            if (slotsListener != null) {
                slotsListener.newImage(drawables[currentIndex]);
            }
        }
    }

    public void stopSlots() {
        isStarted = false;
    }
}



package com.scenariobasedquestion.gamebox;

public class ArcadeGame extends Game {
    private int highScore;
    
    public ArcadeGame(String title, double price) {
        super(title, "Arcade", price);
        this.highScore = 0;
    }
    
    @Override
    public void download() {
        System.out.println("Downloading arcade game: " + getTitle());
        System.out.println("Size: 150 MB");
        System.out.println("Download complete!");
    }
    
    @Override
    public void playDemo() {
        System.out.println("\n--- Playing " + getTitle() + " Demo ---");
        System.out.println("Fast-paced action gameplay!");
        System.out.println("Try to beat the high score!");
        System.out.println("Demo time: 5 minutes");
        System.out.println("Unlimited lives in demo mode");
        System.out.println("Full game has 50+ levels!");
    }
    
    public void setHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            System.out.println("New high score: " + score);
        }
    }
    
    public int getHighScore() {
        return highScore;
    }
}

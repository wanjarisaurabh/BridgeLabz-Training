package com.scenariobasedquestion.gamebox;

public class StrategyGame extends Game {
    private int campaignLevels;
    
    public StrategyGame(String title, double price, int campaignLevels) {
        super(title, "Strategy", price);
        this.campaignLevels = campaignLevels;
    }
    
    @Override
    public void download() {
        System.out.println("Downloading strategy game: " + getTitle());
        System.out.println("Size: 800 MB");
        System.out.println("Installing game assets...");
        System.out.println("Download complete!");
    }
    
    @Override
    public void playDemo() {
        System.out.println("\n--- Playing " + getTitle() + " Demo ---");
        System.out.println("Build your empire and command armies!");
        System.out.println("Demo includes tutorial mission");
        System.out.println("Learn resource management and tactics");
        System.out.println("Demo time: 15 minutes");
        System.out.println("Full game has " + campaignLevels + " campaign levels!");
    }
    
    public int getCampaignLevels() {
        return campaignLevels;
    }
}

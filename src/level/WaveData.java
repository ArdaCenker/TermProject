package level;

//150123012 Arda Cenker Karagöz
public class WaveData {
	//class for handling enemy waves
	private int enemyCount;
	private double spawnInterval;
	private int delay;
	
	public WaveData(int enemyCount, double spawnInterval, int delay) {
		this.enemyCount = enemyCount;
		this.spawnInterval = spawnInterval;
		this.delay = delay;
	}
	
	//getter and setters
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public double getSpawnTime() {
		return spawnInterval;
	}
	public void setSpawnTime(double spawnTime) {
		this.spawnInterval = spawnTime;
	}
	public int getEnemyCount() {
		return enemyCount;
	}
	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
}

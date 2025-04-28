package level;

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

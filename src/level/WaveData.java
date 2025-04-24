package level;

public class WaveData {
	
	private int enemyCount;
	private double spawnTime;
	private int delay;
	
	public WaveData(int enemyCount, double spawnTime, int delay) {
		this.enemyCount = enemyCount;
		this.spawnTime = spawnTime;
		this.delay = delay;
	}
	
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public double getSpawnTime() {
		return spawnTime;
	}
	public void setSpawnTime(double spawnTime) {
		this.spawnTime = spawnTime;
	}
	public int getEnemyCount() {
		return enemyCount;
	}
	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
}

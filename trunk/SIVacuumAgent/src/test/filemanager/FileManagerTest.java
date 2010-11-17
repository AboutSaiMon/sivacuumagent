package test.filemanager;

import exception.FileManagerException;
import file.FileManager;
import vacummAgent.VAFloor;
import vacummAgent.VATile;


public class FileManagerTest {

	
	public static void main(String[] args) throws FileManagerException {
		VAFloor load = FileManager.load("esempio.map");
		System.out.println("Size = "+load.getSize());
		VATile[][] map = load.getFloor();
		for (VATile[] tiles : map) {
			for (VATile tile : tiles) {
				System.out.print(tile.getStatus().ordinal());
			}
			System.out.println();
		}
		FileManager.save(load, "esempiosave.map");
	}
}

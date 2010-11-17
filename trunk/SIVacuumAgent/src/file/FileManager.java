package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import vacummAgent.VAFloor;
import vacummAgent.VATile;
import vacummAgent.VATile.VATileStatus;


/**
 * @author Giovanna,Maria,Antonia
 * 
 */
public class FileManager {
	public static VAFloor load(String filePath) throws FileManagerException {
		File file = new File(filePath);
		VAFloor floor = createByStream(file);
		return floor;
	}

	private static VAFloor createByStream(File file) throws FileManagerException {
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(file);
		} catch (IOException e) {
			throw new FileManagerException(e);
		}
		if (!lines.get(0).trim().matches("size=[0-9]+"))
			throw new FileManagerException(
					"La mappa caricata non è corretta : dimensione non dichiarata correttamente");
		Integer sizeMap = Integer.parseInt(lines.get(0).trim()
				.replace("size=", ""));
		if (lines.size() - 1 != sizeMap)
			throw new FileManagerException(
					"La mappa caricata non è corretta : il numero di righe della mappa non corrisponde alla dimensione dichiarata");
		VAFloor floor = new VAFloor();
		VATile[][] tiles = initMap(sizeMap);
		for (int i = 1; i < lines.size(); i++) {
			String rowString = lines.get(i);
			if (rowString.length() != sizeMap)
				throw new FileManagerException(
						"La mappa caricata non è corretta : il numero di colonne della mappa non corrisponde alla dimensione dichiarata");
			for (int j = 0; j < rowString.length(); j++) {
				int ordinal= Integer.parseInt(String.copyValueOf(new char[]{rowString.charAt(j)}));
				VATileStatus type = VATileStatus.values()[ordinal];
				tiles[i - 1][j].setStatus(type);
			}
		}
		floor.setSize(sizeMap);
		floor.setFloor(tiles);
		return floor;

	}

	private static VATile[][] initMap(Integer sizeMap) {
		VATile[][] tiles = new VATile[sizeMap][sizeMap];
		for (int i = 0; i < sizeMap; i++) {
			for (int j = 0; j < sizeMap; j++) {
				tiles[i][j] = new VATile();
			}
		}
		return tiles;
	}

	public static void save(VAFloor floor, String filePath)
			throws FileManagerException {

		Collection<String> lines = generateStream(floor);
		File file = new File(filePath);
//		CONTROLLO SE IL FILE ESISTE...
//		if (file.exists())
//			throw new FileManagerException("File esistente");
		try {
			FileUtils.writeLines(file, lines);
		} catch (IOException e) {
			throw new FileManagerException(e);
		}

	}

	private static Collection<String> generateStream(VAFloor floor) {
		List<String> map = new ArrayList<String>();
		String sizeLines = "size=" + floor.getSize();
		map.add(sizeLines);
		VATile[][] tiles = floor.getFloor();
		for (VATile[] tilesRow : tiles) {
			String rowLine = "";
			for (VATile tileCol : tilesRow) {
				rowLine += tileCol.getStatus().ordinal();
			}
			map.add(rowLine);
		}
		return map;
	}

}

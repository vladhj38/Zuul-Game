package xml;

import java.io.PrintWriter;
import java.util.Set;

import model.Room;
import model.object.*;



public class RoomWriter {
	private static final String START_ROOM = "<Room>";
	private static final String END_ROOM = "</Room>";
	
	public RoomWriter(Room room, PrintWriter out) {
		write(room, out);
	}

	private void write(Room room, PrintWriter out) {
		out.println(START_ROOM);
		Set<String> keys = room.getWalls().keySet();
		for(String direction : keys)
		{
			if(room.getWall(direction).getExit()!=null)
			{
				ExitWriter temp = new ExitWriter(room.getWall(direction).getExit(), direction, out);
			}
			if(room.getWall(direction).getMonster()!=null)
			{
				MonsterWriter temp = new MonsterWriter(room.getWall(direction).getMonster(),direction, out);
			}
			if(room.getWall(direction).getItem()!=null)
			{
				ItemWriter temp = new ItemWriter(room.getWall(direction).getItem(),direction, out);
			}
		}
		out.println(END_ROOM);
	}
}
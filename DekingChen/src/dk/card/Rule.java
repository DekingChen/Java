package dk.card;

import java.util.Comparator;

public interface Rule extends Comparator<Player> {

	public int compare(Player o1,Player o2);
}

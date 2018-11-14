package businessModels;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectionsModel {

	public final <T> boolean hasDuplicate(Collection<T> list) {

		Set<T> listWithoutDuplicates = new HashSet<T>();
		listWithoutDuplicates.addAll(list);
		int sizeRaw = list.size();
		int sizeCleaned = listWithoutDuplicates.size();
		if (sizeCleaned == sizeRaw) {
			return false;
		}
		return true;
	}
}

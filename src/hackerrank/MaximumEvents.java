package hackerrank;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/03/19
 * Time:    10:36 AM
 * Given list of arrival and durations of promotional events at a venue.
 * Only one event can be promoted at a time. find maximum events which can be conducted at the event.
 *
 * http://scanftree.com/Data_Structure/activity-selection-problem
 *
 */
public class MaximumEvents {

  public static void main(String[] args) {

    List<Integer> arrival  = Arrays.asList(new Integer[] {0,1,2,3,3,5,5,6,8,8,12});
    List<Integer> duration = Arrays.asList(new Integer[] {6,3,12,6,2,2,4,4,3,4,4});
    System.out.println(maxEvents(arrival,duration));

  }

  private static int maxEvents(List<Integer> arrival, List<Integer> duration) {

    List<Integer> finishTime = new ArrayList<>();
    int size = arrival.size();
    Set<Activity> selectedActivities = new HashSet<>();

    for (int i = 0; i < arrival.size(); i++) {
      finishTime.add(arrival.get(i) + duration.get(i));
    }

    List<Activity> activities = new ArrayList<>();

    for (int i = 0; i < arrival.size(); i++) {
      Activity activity = new Activity(arrival.get(i), finishTime.get(i));
      activities.add(activity);
    }

    Collections.sort(activities, (a,b) -> a.getEndTime() - b.getEndTime());
    selectedActivities.add(activities.get(0));
    int st = 0;

    for (int i = 0; i < size; i++) {
      if ( activities.get(i).getStartTime() >= st) {
        selectedActivities.add(activities.get(i));
        st = activities.get(i).getEndTime();
      }

    }

    return selectedActivities.size();
  }

  @Getter
  @Setter
  private static class Activity implements Comparable<Activity> {

    Integer startTime;
    Integer endTime;

    Activity(Integer st, Integer et) {
      this.startTime = st;
      this.endTime = et;
    }

    @Override
    public int compareTo(Activity o) {
      return this.endTime.compareTo(o.endTime);
    }


  }
}

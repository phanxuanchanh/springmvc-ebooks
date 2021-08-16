package SpringMVC.Common;

public class StarRating {
	private long upvote;
	private long downvote;

	public StarRating(long upvote, long downvote) {
		this.upvote = upvote;
		this.downvote = downvote;
	}

	private double SovleUpvotePercent() {
		if (upvote == 0 && downvote == 0)
			return 0;
		return ((double) upvote / (upvote + downvote)) * 100;
	}

	public int SolveStar() {
		double upvotePercent = SovleUpvotePercent();
		if (upvotePercent >= 80)
			return 5;
		else if (upvotePercent >= 60)
			return 4;
		else if (upvotePercent >= 40)
			return 3;
		else if (upvotePercent >= 20)
			return 2;
		else if (upvotePercent > 0)
			return 1;
		else
			return 0;
	}
}

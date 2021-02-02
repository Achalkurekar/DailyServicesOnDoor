package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "user_feedback")
public class UserFeedBack {


		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="feedback_Id")
		private Integer FeedbackId;


		@Column(name="description")
		private String Description;

		@Column(name="rating")
		private Integer Rating;

		
		public UserFeedBack() {
			System.out.println("in constructor of "+getClass().getName());

		}
		
		public UserFeedBack(Integer feedbackId, String description, Integer rating) {
			super();
			FeedbackId = feedbackId;
			Description = description;
			Rating = rating;
		}





		public Integer getFeedbackId() {
			return FeedbackId;
		}

		public void setFeedbackId(Integer feedbackID) {
			FeedbackId = feedbackID;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public Integer getRating() {
			return Rating;
		}

		public void setRating(Integer rating) {
			Rating = rating;
		}

		@Override
		public String toString() {
			return "UserFeedBack [FeedbackId=" + FeedbackId + ", Description=" + Description + ", Rating=" + Rating
					+ "]";
		}
	

}

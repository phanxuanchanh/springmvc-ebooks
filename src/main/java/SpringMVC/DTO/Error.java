package SpringMVC.DTO;

public class Error {
	private String message;
	private String stackTrace;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Error(String message, String stackTrace) {
		super();
		this.message = message;
		this.stackTrace = stackTrace;
	}

	public Error() {
		super();
	}
}

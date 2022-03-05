package testing.mocks.telemetry;

import java.time.LocalDateTime;
import java.util.Random;

public class TelemetryClient {
	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";



	public static class ClientConfiguration {
		enum  AckMode {NORMAL, TIMEBOXED, FLOOD};
		private String sessionId;
		private LocalDateTime sessionStart;
		private AckMode ackMode;

		public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}

		public LocalDateTime getSessionStart() {
			return sessionStart;
		}

		public void setSessionStart(LocalDateTime sessionStart) {
			this.sessionStart = sessionStart;
		}

		public AckMode getAckMode() {
			return ackMode;
		}

		public void setAckMode(AckMode ackMode) {
			this.ackMode = ackMode;
		}
	}

	private boolean onlineStatus;
	private String diagnosticMessageResult = "";

	private final Random connectionEventSimulator = new Random(42);

	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	public void connect(String telemetryServerConnectionString) {
		if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
			throw new IllegalArgumentException();
		}

		onlineStatus = connectionEventSimulator.nextInt(10) <= 8;
	}

	public String getVersion() {
		return "1.3";
	}

	public void disconnect(boolean force) {
		onlineStatus = false;
		throw new IllegalStateException("Performs some external remote call impossible");
	}

	public void send(String message) {
		if (message == null || "".equals(message)) {
			throw new IllegalArgumentException();
		}

		if (message.equals(DIAGNOSTIC_MESSAGE)) {
			//simulate a status report;
			diagnosticMessageResult = "LAST TX rate................ 100MBPS\r\n"
					+ "HIGHEST TX rate............. 100 MBPS\r\n"
					+ "LAST RX rate................ 100MBPS\r\n"
					+ "HIGHEST RX rate............. 100MBPS\\r\\n"
					+ "BIT RATE.................... 100MBPS\r\n"
					+ "WORD LEN.................... 16\r\n"
					+ "WORD/FRAME.................. 511\r\n"
					+ "BITS/FRAME.................. 8192\r\n"
					+ "MODULATION TYPE............. PCM/FRAME\r\n"
					+ "TX Digital Los.............. 0.75\r\n"
					+ "RX Digital Los.............. 0.10\r\n"
					+ "BEP TEST.................... -5\r\n"
					+ "Local Rtrn Count............ 00\r\n"
					+ "Remote Rtrn Count........... 00";

		}
		// here should go the real Send Operation
	}

	public String receive() {
		String message;

		if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult)) {
			// simulate a received message
			message = "";
			int messageLength = connectionEventSimulator.nextInt(50) + 60;

			 for (int i = messageLength; i >= 0; --i) {
				 message += (char) connectionEventSimulator.nextInt(40) + 86;
			 }
		} else {
			message = diagnosticMessageResult;
			diagnosticMessageResult = "";
		}

		return  message;
	}

	public void configure(ClientConfiguration config) {

	}
}

package view.packets;

import view.packets.requests.Request;

public class RequestPacket {
    private Request request;

    public RequestPacket(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }
}

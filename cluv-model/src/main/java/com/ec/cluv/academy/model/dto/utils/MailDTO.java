package com.ec.cluv.academy.model.dto.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MailDTO {
    private String from;
    private String to;
    private String subject;
    private String content;

    public MailDTO() {
    }

    @Override
    public String toString() {
        return "Mail{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", subject='" + subject + '\'' + ", content='"
                + content + '\'' + '}';
    }
}

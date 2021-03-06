package com.vipshop.microscope.collector.disruptor;

import com.lmax.disruptor.EventHandler;
import com.vipshop.microscope.collector.analyzer.MessageAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exception analyze handler.
 *
 * @author Xu Fei
 * @version 1.0
 */
public class ExceptionAnalyzeHandler implements EventHandler<ExceptionEvent> {

    public static final Logger logger = LoggerFactory.getLogger(ExceptionAnalyzeHandler.class);

    private final MessageAnalyzer messageAnalyzer = MessageAnalyzer.getMessageAnalyzer();

    @Override
    public void onEvent(final ExceptionEvent event, long sequence, boolean endOfBatch) throws Exception {
        messageAnalyzer.analyze(event.getResult());
    }


}
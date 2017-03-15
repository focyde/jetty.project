//
//  ========================================================================
//  Copyright (c) 1995-2017 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.jsr356.decoders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * Decode Date and Time
 */
public class DateTimeDecoder implements Decoder.Text<Date>
{
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");

    @Override
    public Date decode(String s) throws DecodeException
    {
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
            dateFormat.setTimeZone(GMT);
            return dateFormat.parse(s);
        }
        catch (ParseException e)
        {
            throw new DecodeException(s, e.getMessage(), e);
        }
    }

    @Override
    public void destroy()
    {
    }

    @Override
    public void init(EndpointConfig config)
    {
    }

    @Override
    public boolean willDecode(String s)
    {
        return true;
    }
}
